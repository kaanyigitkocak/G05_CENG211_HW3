package BusinessLayer;

public class Member {
    private String type;
    private boolean hasScholarship;

    public Member(String type, boolean hasScholarship) {
        this.setType(type);
        this.setHasScholarship(hasScholarship);
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isHasScholarship() {
		return hasScholarship;
	}

	public void setHasScholarship(boolean hasScholarship) {
		this.hasScholarship = hasScholarship;
	}


}