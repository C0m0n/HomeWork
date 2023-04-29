import binascii

#This function will open the keyfile and get the length of the key as well as the key.
def openKey():
    keyFile = open("key.txt", "rb")
    try:
        #key = binascii.hexlify(keyFile.read())
        key = keyFile.read()
        keyLength = len(key)

    finally:
        keyFile.close()
    return keyLength, key

#This function will open the ciphertext file and get the ciphertext.
def openPlainText():
    plainTextFile = open("input.txt", "rb")
    try:
        #plainText = binascii.hexlify(plainTextFile.read())
        plainText = plainTextFile.read()

    finally:
        plainTextFile.close()
    return plainText

#This function will will do the add round key portion of the AES algorithm.
def addRoundKey(key, plainText):
    roundKey = []
    for i in range(0, len(plainText)):
        roundKey.append(plainText[i] ^ key[i])
    return roundKey

def test():
    with open('key.txt') as f:
        for line in f:
            line = line.strip()
        
        line = int(line,16)        
    
    with open('input.txt', 'r') as l:
        for line2 in l:
            line2 = line2.strip()

        line2 = int(line2,16)

    return hex(line), hex(line2)
        

def main():
    keyLength, key = openKey()
    key, plainText = test()
    #plainText = openPlainText()
    keyLength *= 4
    print("Key Length: ")
    print(keyLength)
    print("Key: ")
    print(key)
    print("Plaintext: ")
    print(plainText)
    print("Round Key: ")
    print(addRoundKey(key, plainText))
    test()

main()