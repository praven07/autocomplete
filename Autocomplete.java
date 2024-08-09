import java.util.Arrays;
import java.util.Comparator;

public class Autocomplete {

    private Term[] terms;

    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {

        if (terms == null) {
            throw new IllegalArgumentException();
        }

        this.terms = new Term[terms.length];

        for (int i = 0; i < terms.length; i++) {
            if (terms[i] == null) {
                throw new IllegalArgumentException();
            }

            this.terms[i] = terms[i];
        }

        Arrays.sort(this.terms);
    }

    // Returns all terms that start with the given prefix,
    // in descending order of weight.
    public Term[] allMatches(String prefix) {

        if (prefix == null) {
            throw new IllegalArgumentException();
        }

        Comparator<Term> comparator = Term.byPrefixOrder(prefix.length());

        Term searchTerm = new Term(prefix, 0);


        int first = BinarySearchDeluxe.firstIndexOf(terms, searchTerm, comparator);
        int last = BinarySearchDeluxe.lastIndexOf(terms, searchTerm, comparator);

        if (first == -1 || last == -1) {
            return new Term[0];
        }

        Term[] result = new Term[(last - first) + 1];
        for (int i = first; i <= last; i++) {
            result[i - first] = terms[i];
        }

        Arrays.sort(result, Term.byReverseWeightOrder());

        return result;
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        return allMatches(prefix).length;
    }
}
