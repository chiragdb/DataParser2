public class ElectionResult {
    private double votes_dem, votes_gop, total_votes, per_dem, per_gop;
    private int diff;
    private double per_point_diff;
    private String state_abbr, country_name;
    private int combined_fips;

    public ElectionResult(double votes_dem, double votes_gop, double total_votes, double per_dem, double per_gop, int diff, double per_point_diff, String state_abbr, String country_name, int combined_fips){
        this.votes_dem = votes_dem;
        this.votes_gop = votes_gop;
        this.total_votes = total_votes;
        this.per_dem = per_dem;
        this.per_gop = per_gop;
        this.diff = diff;
        this.per_point_diff = per_point_diff;
        this.state_abbr = state_abbr;
        this.country_name = country_name;
        this.combined_fips = combined_fips;
    }

    private double getVotes_dem() {
        return votes_dem;
    }

    private void setVotes_dem(double votes_dem) {
        this.votes_dem = votes_dem;
    }

    private double getVotes_gop() {
        return votes_gop;
    }

    private void setVotes_gop(double votes_gop) {
        this.votes_gop = votes_gop;
    }

    private double getTotal_votes() {
        return total_votes;
    }

    private void setTotal_votes(double total_votes) {
        this.total_votes = total_votes;
    }

    private double getPer_dem() {
        return per_dem;
    }

    private void setPer_dem(double per_dem) {
        this.per_dem = per_dem;
    }

    private double getPer_gop() {
        return per_gop;
    }

    private void setPer_gop(double per_gop) {
        this.per_gop = per_gop;
    }

    private int getDiff() {
        return diff;
    }

    private void setDiff(int diff) {
        this.diff = diff;
    }

    private double getPer_point_diff() {
        return per_point_diff;
    }

    private void setPer_point_diff(double per_point_diff) {
        this.per_point_diff = per_point_diff;
    }

    private String getState_abbr() {
        return state_abbr;
    }

    private void setState_abbr(String state_abbr) {
        this.state_abbr = state_abbr;
    }

    private String getCountry_name() {
        return country_name;
    }

    private void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    private int getCombined_fips() {
        return combined_fips;
    }

    private void setCombined_fips(int combined_fips) {
        this.combined_fips = combined_fips;
    }
    public String toString(){
        String output1 = ("Votes Dem - " + votes_dem + ", Votes Gop - " + votes_gop + ", Total Votes - " + total_votes + ", Per Dem - " + per_dem + ", Per Gop - " + per_gop);
        String output2 = (" Difference - " + diff + ", Per Point Difference - " + per_point_diff + ", State Abbr - " + state_abbr + ", Country - " + country_name + ", Comhined Fips - " + combined_fips);
        String output = output1 + output2;
        return output;

    }
}
