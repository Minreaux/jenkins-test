// Global variable with multiple methods (AKA Multi-method custom step)
def hello() {
    File greetingFile = new File("hello.txt")
    echo("Hello, human")
}

def goodbye() {
    echo("Goodbye, human.")
}
