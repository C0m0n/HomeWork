
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>

#define HALT_OPCODE 0x19

void storeInMem(uint8_t *targetMem, uint16_t value);
uint16_t loadFromMem(uint8_t *sourceMem);
void readInput(void);
void writeOutput(void);

uint8_t  IR = 0; 
uint8_t  ACC = 0; 
uint16_t  MAR = 0;
uint16_t PC = 0; 
uint8_t memory[65536] = {0}; 

void executeInstruction() {

    // Math
    if( (IR & 0x80)) {
       
        int numOfBits = 16;
        uint16_t *targetMem;
        uint16_t *sourceMem;

        //Figure out the targetMem
        switch (IR & 0x0C) {

            case 0x00: 
                targetMem = (uint16_t *) &memory[MAR];
                break;

            case 0x04: 
                targetMem = (uint16_t *) &ACC;
                numOfBits = 8;
                break;

            case 0x08: 
                targetMem = &MAR;
                break;

            case 0x0C:
                targetMem = (uint16_t *) &memory[loadFromMem((uint16_t *)&memory[PC-2])];
                break;

            default:
                printf("Invalid targetMem.\n");
                return;
        }

        // Figure out the sourceMem
        switch ((IR & 0x03)) {

            case 0x00:
                sourceMem = (uint16_t *) &memory[MAR];
                break;

            case 0x01:
                sourceMem = &ACC;
                break;

            case 0x02:

                if (numOfBits == 16) {
                    sourceMem = (uint16_t *) &memory[PC - 2];
                } else {
                    sourceMem = (uint16_t *) &memory[PC - 1];
                }
                break;

            case 0x03:
                sourceMem = (uint16_t *) &memory[loadFromMem((uint16_t *)&memory[PC-2])];
                break;

            default:
                printf("Invalid sourceMem.\n");
                return;
        }

        uint16_t sourceValue = 0;
        uint16_t destinationValue = 0;

        // Load the sourceMem and targetMem values
        if (numOfBits == 16) {
            sourceValue = loadFromMem(sourceMem);  
            destinationValue = loadFromMem(targetMem);
        } else {
            sourceValue = *sourceMem & 0xFF;
            destinationValue = *targetMem & 0xFF;
        }
        // Do the math
        switch (IR & 0x70) {

            case 0x00: 
                destinationValue&=sourceValue;
                break;

            case 0x10: 
                destinationValue |=  sourceValue;
                break;

            case 0x20: 
                destinationValue ^= sourceValue;
                break;

            case 0x30:
                destinationValue += sourceValue;
                break;

            case 0x40: 
                destinationValue -= sourceValue;
                break;

            case 0x50: 
                destinationValue += 1;
                break;

            case 0x60: 
                destinationValue -= 1;
                break;

            case 0x70: 
                destinationValue = ~destinationValue;
                break;

            default:
                printf("Invalid math operation.\n");
                return;
        }
        // Store in the targetMem
        if(numOfBits == 16) {
            storeInMem(targetMem, destinationValue);
        } else {
            *targetMem = destinationValue & 0xFF;
        }
    }
    //Check next type of instruction
    else if ( (IR & 0xF0) == 0x0) {
        int numOfBits = 16;
        uint8_t *op;
        uint16_t *targetRegister = NULL; // Move the declaration here

        if (IR & 0x04) {

            targetRegister = &MAR;
            numOfBits = 16;
        }
        else {

            targetRegister = &ACC;
            numOfBits = 8;
        }

        if ((IR & 0x03) == 0x00) {

            op = &memory[loadFromMem((uint16_t *)&memory[PC - 2])];
        }
        else if ((IR & 0x03) == 0x01) {

            if (IR & 0x04) {

                op = &memory[PC-2];
            }
            else {

                op = &memory[PC-1];
            }
        }

        else if ((IR&0x03) == 0x02) {

            op = &memory[MAR];
        }

        if ((IR&0x04)) {

            targetRegister = &MAR;
            numOfBits = 16;
        }
        else {

            targetRegister = &ACC;
            numOfBits = 8;
        }  
        if ( (IR & 0x03) == 0x00) {

            op = &memory[loadFromMem(&memory[PC - 2])];
        } 
        else if ((IR & 0x03) == 0x01) { 

            if ((IR & 0x04)) {

                op = &memory[PC - 2];
            } 
            else {

                op = &memory[PC - 1];
            }
        } 
        else if ( (IR & 0x03) == 0x02) {

            op = &memory[MAR];
        }  
        if ( (IR & 0x08) == 0x08) {

            if (numOfBits == 16) {

                *targetRegister = loadFromMem(op);
            } else {

                *targetRegister = *op & 0xFF;
            }
        }
        else if ( (IR & 0x08) == 0x00){

            if (numOfBits == 16) {

                storeInMem(op, *targetRegister);
            } else {

                *op = *targetRegister & 0xFF;
            }
        }
    }
    // Check if branch
    else if( (IR & 0xF8) == 0x10) {
        uint16_t branchAddress = loadFromMem(&memory[PC-2]);
        switch ( (IR & 0x07)) {
            case 0x00: 
                PC = branchAddress;
                break;

            case 0x01: 
                if (ACC == 0) PC = branchAddress;
                break;

            case 0x02: 
                if (ACC != 0) PC = branchAddress;
                break;

            case 0x03: 
                if (ACC < 0) PC = branchAddress; 
                break;

            case 0x04: 
                if (ACC <= 0) PC = branchAddress;
                break;

            case 0x05: 
                if (ACC > 0) PC = branchAddress;
                break;

            case 0x06: 
                if (ACC >= 0) PC = branchAddress;
                break;

        }
    }

    else {
        //NOP
        if ((IR == 0x18)) {

            return;
        }
        //halt             
        else if ( (IR == 0x19)) {

            return;
        } else {

            printf("Illegal opcode at PC: %04x\n", PC - 1);
            return;
        }
    }
}

void fetchNextInstructions() {
    IR = memory[PC];
    PC++;

    // math 
    if (IR & 0x80) {
        
        if ( (IR & 0x0C) == 0x0C) {

            PC += 2;
        } else {

            // sourceMem is constant
            if ( (IR & 0x03) == 0x02) {

                // ACC is targetMem, 8 bit
                if ( (IR & 0x0C) == 0x04) {
                    PC++;
                } else { 
                    PC++;
                }
            } 
            // sourceMem mem
            else if ( (IR & 0x03) == 0x03) {
                PC += 2;
            } 
        }
    }

    // memory op 
    else if ( (IR & 0xF0) == 0x00) {

        // address
        if ( (IR & 0x03) == 0x00) {
            PC += 2;
        }
        // constant
        else if ( (IR & 0x03) == 0x01) {

            if (IR & 0x04) {
                PC += 2;
            } 
            else {
                PC++;
            }
        }
    }
    // branch op
    else if ( (IR & 0xF8) == 0x10) {

        // branch
        PC += 2;
    }
}

uint16_t loadFromMem(uint8_t *sourceMem) {
    //Get the value from the memory
    return (((uint16_t) *sourceMem) << 8) | ((uint16_t)*(sourceMem+1));
}

void storeInMem(uint8_t *targetMem, uint16_t value) {
    //Store the value in the memory
    *targetMem = (value >> 8) & 0xFF;
    *(targetMem + 1) = value & 0xFF;
}


//Read the input file
void readInput() {
    FILE* file = fopen("mem_in.txt", "r");
    int index = 0;
    //Cannot open file
    if(file == NULL) {
        printf("Error opening file.");
        exit(1);
    }


    //Read in the whole file
    while(fscanf(file, "%02x", &memory[index]) != EOF) {
        index++;
    }

    fclose(file);
}


//Write to the output file
void writeOutput() {
    FILE* file = fopen("mem_out.txt", "w");

    if(file == NULL) {
        printf("Error opening file.");
        exit(1);
    }

    int i = 0;
    while (i < 65536) {
        fprintf(file, "%02x ", memory[i]);
        if ((i + 1) % 16 == 0 && i != 65536) 
            fprintf(file, "\n");
        i++;
    }

    fclose(file);
}

int main(int argc, char *argv[]) {
    readInput();
    while(memory[PC] != HALT_OPCODE) {
        fetchNextInstructions();
        executeInstruction();
    }
    writeOutput();
    return 0;
}

