/*
	readImage.c
	This program demonstrates how to read and write to binary files.
	The input file represents a fictitious image format described as follows:
		The first 4 bytes are in the header and have the value PIC2 that represents the type of data.
		The next 4 bytes are also in the header and have the value ab99 that represents the format.
		Following the header is a data chunk where:
			The first byte is a packed byte
			IF bits 7 and 2 in the packed byte are set, the next 24 bytes are a color table.
			Following the color table (if it exists) is another 24 bytes of data. If there is no color table, 48 bytes of data follow the packed byte directly.
*/
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char ** argv)
{
	FILE * fpIn;
	FILE * fpOut;
	unsigned char header[9];
	unsigned char packedByte;
	unsigned char colorTable[8][3];
	unsigned char data[48];
	int amountRead = 0;
	
	if((fpIn = fopen("image.pic", "rb")) == NULL)
	{
		perror("Error opening image file");
		exit(EXIT_FAILURE);
	}
	
	if((fpOut = fopen("screen.pic", "wb")) == NULL)
	{
		perror("Error opening screen file");
		exit(EXIT_FAILURE);
	}
	
	/* Attempt to read the 8-byte header */
	/* Parameters: memory location, size of element, number of elements, file pointer */
	if(fread(header, 1, 8, fpIn) != 8)
	{
		perror("Problems reading header");
		exit(EXIT_FAILURE);		
	}
	
	/* Display the header */
	header[8] = '\0';
	printf("Header: %s\n", header);
	
	/* Attempt to read the packed byte */
	if(fread(&packedByte, 1, 1, fpIn) != 1)
	{
		perror("Problems reading packed byte");
		exit(EXIT_FAILURE);		
	}
	
	printf("Packed byte: %02X\n", packedByte);
	
	/* Use packetByte to determine if to read a color table or just data. */
	if((packedByte & 0x84) == 0x84) /* next 24 bytes is a color table followed by 24 bytes of data */
	{
		/* Attempt to read color table */
		if(fread(colorTable, sizeof(colorTable), 1, fpIn) != 1)
		{
			perror("Problems reading color table");
			exit(EXIT_FAILURE);		
		}
		
		/* Attempt to read 24 bytes of data following color table*/
		if(fread(data, 1, 24, fpIn) != 24)
		{
			perror("Problems reading data following color table");
			exit(EXIT_FAILURE);		
		}
		
		amountRead = 24;
	}
	else
	{
		/* Attempt to read 48 bytes of data following packed byte*/
		if(fread(data, 1, 48, fpIn) != 48)
		{
			perror("Problems reading data following the packed byte");
			exit(EXIT_FAILURE);		
		}
		amountRead = 48;
	}
	
	/* Write color data to screen.pic file */
	
	if((packedByte & 0x84) == 0x84) /* use color table to determine colors */
	{
		int i = 0;
		for(; i < amountRead; i++)
		{
			int j = 0;
			if(fwrite(&colorTable[data[i]], 1, 3, fpOut) != 3)
			{
				perror("Problems writing data to screen file");
				exit(EXIT_FAILURE);						
			}
			for(; j < 3; j++)
			{
				printf("%02X", colorTable[data[i]][j]);
			}
			printf(" ");
			if((i+1) % 8 == 0)
				printf("\n");
		}
	}
	else /* the data represent the colors themselves */
	{
		if(fwrite(data, sizeof(data), 1, fpOut) != 1)
		{
			perror("Problems writing data to screen file");
			exit(EXIT_FAILURE);		
		}
	}
	
	fclose(fpIn);
	fclose(fpOut);
}
