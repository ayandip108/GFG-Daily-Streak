class Solution {
    
    private StringBuilder readString;
    private StringBuilder redoTracker;
    
    public Solution() {
        readString = new StringBuilder();
        redoTracker = new StringBuilder();
    }
    
    public void append(char x) {
        // append x into document
        readString.append(x);
    }

    public void undo() {
        // undo last change
        char lastChar = readString.charAt(readString.length() - 1);
        readString.deleteCharAt(readString.length() - 1);
        redoTracker.append(lastChar);
    }

    public void redo() {
        // redo changes
        char lastRedoChar = redoTracker.charAt(redoTracker.length() - 1);
        redoTracker.deleteCharAt(redoTracker.length() - 1);
        readString.append(lastRedoChar);
    }

    public String read() {
        // read the document
        return readString.toString();
    }
}