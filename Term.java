import java.util.Comparator;

public class Term implements Comparable<Term> {

    // Search query string
    private String query;

    // Search term weight
    private long weight;

    // Initializes a term with the given query string and weight.
    public Term(String query, long weight) {

        if (query == null || weight < 0) {
            throw new IllegalArgumentException();
        }

        this.query = query;
        this.weight = weight;
    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that) {

        return query.compareTo(that.query);
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        return weight + "   " + query;
    }

    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder() {
        return new ReverseWeightOrderComparator();
    }

    // Compares the two terms in lexicographic order,
    // but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {

        if (r < 0) {
            throw new IllegalArgumentException();
        }

        return new PrefixOrder(r);
    }

    private static class ReverseWeightOrderComparator implements Comparator<Term> {

        public int compare(Term o1, Term o2) {
            return Double.compare(o2.weight, o1.weight);
        }
    }

    private static class PrefixOrder implements Comparator<Term> {

        // Length of the prefix
        private int r;

        // Initializes r for the length of the query prefix to compare.
        public PrefixOrder(int r) {
            this.r = r;
        }

        public int compare(Term o1, Term o2) {
            return o1.query.substring(0, r).compareTo(o2.query.substring(0, r));
        }
    }
}
