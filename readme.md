## Introduction
A project to explore features of Scala Native.

## Usage

### Run
Run the app via
```
./mill run
```

### Inspect NIR
If you want to view the [Native Intermediate Representation](https://scala-native.org/en/stable/contrib/nir.html) in human readable text form, follow the steps below.

1. Install the tool [scala-native-cli](https://github.com/scala-native/scala-native-cli).
2. Convert a `nir` file to text form.
    ```
    cd out/compile.dest/classes
    scala-native-p -v --from-path Main$.nir > Main$.hnir
    ```