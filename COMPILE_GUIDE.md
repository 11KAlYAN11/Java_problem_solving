# Compilation Guide

## Quick Start

For most files, simply use:
```bash
./run.sh <path/to/File.java>
```

## Files with Dependencies in Same Package

Some files depend on other classes in the same package. When compiling these, you need to compile all related files together.

### Example: OOPS Package

The `AnimalCatDogMain.java` file depends on `Animal.java`, `Cat.java`, and `Dog.java`. To compile:

```bash
# Method 1: Compile all related files explicitly
javac -d out -sourcepath . OOPS/Animal.java OOPS/Cat.java OOPS/Dog.java OOPS/AnimalCatDogMain.java
java -cp out com.learning.java.oops.AnimalCatDogMain

# Method 2: Use the helper script (compiles single file, dependencies found via -sourcepath)
# Note: This works only if dependencies are already compiled or if javac can find them
./run.sh OOPS/AnimalCatDogMain.java
```

If you get "cannot find symbol" errors, compile the dependencies first:

```bash
# Compile base classes first
javac -d out -sourcepath . OOPS/Animal.java
javac -d out -sourcepath . OOPS/Cat.java OOPS/Dog.java
# Then compile the main file
javac -d out -sourcepath . OOPS/AnimalCatDogMain.java
java -cp out com.learning.java.oops.AnimalCatDogMain
```

## Common Patterns

### Single File (No Dependencies)
```bash
./run.sh Hello.java
./run.sh General_Problems/Demo1.java
```

### Files with Same-Package Dependencies
```bash
# Compile all related files together
javac -d out -sourcepath . <file1> <file2> <file3>...
java -cp out <package>.<ClassName>
```

### Files with Cross-Package Dependencies
If a file imports from another package, use `-sourcepath .` and compile normally:
```bash
./run.sh <path/to/File.java>
```

## Troubleshooting

### "Duplicate class" error
Some packages have multiple classes with the same name (e.g., `Car` in `Car.java` and `BasicClassArch.java`). These are in the same package for learning purposes. Compile them separately, not together.

### "Cannot find symbol" error
1. Check if the class exists in the same package
2. If yes, compile all related files together
3. If no, check if you need to add an import statement

### "Package does not exist" error
1. Make sure you're compiling from the `Java_problem_solving/` directory
2. Use `-sourcepath .` when compiling
3. Check that the package declaration matches the directory structure

## Clean Build

Always clean before a fresh compile:
```bash
./clean.sh
```

