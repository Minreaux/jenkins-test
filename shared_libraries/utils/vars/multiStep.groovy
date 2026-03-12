// Global variable with multiple methods (AKA Multi-method custom step)
def hello(String name = 'human') {
    echo("Hello, ${name}.")
}

def goodbye(String name = 'human') {
    echo("Goodbye, ${name}.")
}
