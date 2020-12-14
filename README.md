# PARM-code-assembler
a Java program that transforms assemble code into hexa machine instruction. Used for a school project.

## About
The goal of this application is to convert ARM-cortex-V0 compatible assembly code in hexadecimal code ready to be executed by an ARM-cortex-V0 CPU.
Keep in mind that this is only a quick school project.
  
However, if you're interested in it, you can still clone the repo and have fun with editing the code.

## Download :
You can download the .jar executable file [here](https://github.com/Natsukooh/PARM-code-assembler/releases/download/v1.0/PARM-code-assembler-1.0.jar).

## Usage :
`java -jar PARM-code-assembler-1.0 <path to assembly file> <path to output file>`

`<assembly file>` is the file to convert, and `<output file>` is the output for the hexadecimal code. If the output file is not provided, the result will be printed in console.

remember that the program only works on assembly code specially compiled for ARM-cortex-m0 architectures. The c compiler that can give you such assembly code is Clang. To get the right assembly code from a c file named main.c, the command is : `clang -S -target arm-none-eabi -mcpu=cortex-m0 -O0 -mfloat-abi=soft main.c`.
  
**WARNING** : Since the 9 version of clang, some c code is compiled differently, with instructions that the java program doesn't implement. To compile the c files, you have to use Clang version 4 to 8, but not 9 nor 10.
  
Clang is downloadable (here)[https://releases.llvm.org/download.html]. To find the 8 or 8.1 version, you have to scroll down a little bit.
