# AES 256 bit Encryption in Java
Advanced Encryption Standard technique implemented using 32 bit long encryption key

## High-level description of the algorithm

    KeyExpansions—round keys are derived from the cipher key using Rijndael's key schedule. 
    AES requires a separate 128-bit round key block for each round plus one more.
    1. #### Initial Round
        _AddRoundKey_ :—each byte of the state is combined with a block of the round key using bitwise xor.
    2. **Rounds**
        SubBytes—a non-linear substitution step where each byte is replaced with another according to a lookup table.
        ShiftRows—a transposition step where the last three rows of the state are shifted cyclically a certain number of steps.
        MixColumns—a mixing operation which operates on the columns of the state, combining the four bytes in each column.
        AddRoundKey
    3. **Final Round (no MixColumns)**
        SubBytes
        ShiftRows
        AddRoundKey.
