FilePartReader class:

It has one constructor:
    - it sets the class's instance variables to some invalid default values

It has three instance methods:
    public void setup()
        - its parameters are:
            - filePath as a String
            - fromLine as an Integer
            - toLine as an Integer
        - it throws an IllegalArgumentException :
            - if toLine is smaller than fromLine
            - if fromLine is smaller than 1
    public String read()
        - opens the file on filePath, and gives back its content as a String
        - it doesn't catch the exception being raised, if the file isn't present on filePath, so actually the method
          throws the exception it received
    public String readLines():
        - reads the file with read()
        - it gives back every line from its content between fromLine and toLine (both of them are included), and returns
          these lines as a String. Take care because if fromLine is 1, it means the very first row in the file. Also,
          if fromLine is 1 and toLine is 1 also, we will read only the very first line.


FileWordAnalyzer class:

It has one constructor :
    - its parameter is a FilePartReader object

It has three instance methods:
    public List getWordsOrderedAlphabetically():
        - calls FilePartReader.readLines()
        - returns the words ordered alphabetically as an ArrayList
    public List getWordsContainingSubstring(String subString):
        - calls FilePartReader.readLines ()
        - returns the words which contain the subString
    public List getStringsWhichArePalindromes():
        - calls FilePartReader.readLines()
        - returns the words from the String which are palindromes

Testing:
When you are ready, your job is to cover your code with tests, and make an assertion for all the statements in the
bullet points. When testing FilePartReader class, you can have a test file with which you can test the read method.