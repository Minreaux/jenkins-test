// Multi-method Custom Step
def hello(String name = 'human') {
    echo("Hello, ${name}.")
}

def goodbye(String name = 'human') {
    echo("Goodbye, ${name}.")
}
