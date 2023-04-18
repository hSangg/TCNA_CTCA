import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

    class Word {
        private String word;
        private String meaning;
        private String type;
        private String note;

        public Word(String word, String meaning, String type, String note) {
            this.word = word;
            this.meaning = meaning;
            this.type = type;
            this.note = note;
        }

        public String getWord() {
            return word;
        }

        public String getMeaning() {
            return meaning;
        }

        public String getType() {
            return type;
        }

        public String getNote() {
            return note;
        }

        public void printInfo() {
            System.out.println("Word: " + word);
            System.out.println("Meaning: " + meaning);
            System.out.println("Type: " + type);
            System.out.println("Note: " + note);
        }

    }

    class Dictionary {
        private TreeMap<String, Word> words;

        public Dictionary() {
            words = new TreeMap<String, Word>();
        }

        public void addWord(String word, String meaning, String type, String note) {
            Word newWord = new Word(word, meaning, type, note);
            words.put(word, newWord);
        }

        public void searchWord(String word) {
            if (words.containsKey(word)) {
                Word w = words.get(word);
                w.printInfo();
            } else {
                System.out.println("Khong co chu nay");
            }
        }
    }

    public class cau_5 {
        public static void main(String[] args) {
            Dictionary dict = new Dictionary();

            dict.addWord("hello", "used as a greeting", "interjection", "");
            dict.addWord("world", "the earth, together with all of its countries, peoples, and natural features", "noun", "");
            dict.addWord("java", "a high-level, class-based, object-oriented programming language", "noun", "");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhap tu de tim: ");
            String word = scanner.nextLine();

            dict.searchWord(word);
        }
    }

