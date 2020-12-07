### Primitive Type
#### Java Primitive Data Types
| Data Type | Size | Description |
|:-----------|:------|:-------------|
| byte | 1 byte	| Stores whole numbers from -128 to 127 |
| short	| 2 bytes | Stores whole numbers from -32,768 to 32,767 |
| int | 4 bytes | Stores whole numbers from -2,147,483,648 to 2,147,483,647 |
| long | 8 bytes | Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 |
| float | 4 bytes | Stores fractional numbers. Sufficient for storing 6 to 7 decimal digits | 
| double | 8 bytes | Stores fractional numbers. Sufficient for storing 15 decimal digits | 
| boolean | 1 bit | Stores true or false values |
| char | 2 bytes | Stores a single character/letter or ASCII values |

#### Java Type Conversion
![TypeConversion](Resources/type_conversion.png "Java Type Conversion")

#### Java Bit Manipulation
- Unary bitwise complement operator: ~
>a = 5 = 0101  
>~a = 1010 = 10  
>so its a flipped value of binary representation of variable

- Bitwise AND: &
>a = 5 = 0101  
>b = 7 = 0111  
>a & b = 0101 = 5  
>so its intuitive and operation

- Bitwise OR: |
>a = 5 = 0101  
>b = 7 = 0111  
>a | b = 0111 = 7  
>so its intuitive or operation

- Bitwise XOR: ^
>a = 5 = 0101  
>b = 7 = 0111  
>a ^ b = 0010 = 2  
>so if different -> 1, if same -> 0

- Signed left shift: <<
>a = 5 = 0000 0101  
>a << 1 = 0000 1010 = 10  
>a << 2 = 0001 0100 = 20  
>a << 3 = 0010 1000 = 40  
>so << means a * 2<sup>n</sup>, n is 1,2,3...here

- Signed right shift: >>
>a = 10 = 0000 1010  
>a >> 1 = 0000 0101 = 5   
>a >> 2 = 0000 0010 = 2  
>so >> means a / 2<sup>n</sup>, n is 1,2...here

- Unsigned right shift: >>>
>a = 10 = 0000 1010
>a >>> 1 = 0000 0101 = 5  
>a >>> 2 = 0000 0010 = 2  
>a >>> 3 = 0000 0001 = 1  
>b = - 10 = reverse(0000 1010) + 1 = (1111 0110)32 bit = 1111 1111 1111 1111 1111 1111 1111 0110  
>b >>> 1 = 0111 1111 1111 1111 1111 1111 1111 1011 = 2147483643  
>so >>> means a / 2<sup>n</sup>, insert to void left with 0, and set leftmost digit to 0


