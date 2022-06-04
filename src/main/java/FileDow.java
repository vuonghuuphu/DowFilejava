public class FileDow {
    private String groupId;
    private String artifactId;
    private String verion;

    public FileDow() {
    }

    @Override
    public String toString() {
        return "FileDow{" +
                "groupId='" + groupId + '\'' +
                ", artifactId='" + artifactId + '\'' +
                ", verion='" + verion + '\'' +
                '}';
    }

    public FileDow(String groupId, String artifactId, String verion) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.verion = verion;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVerion() {
        return verion;
    }

    public void setVerion(String verion) {
        this.verion = verion;
    }
}
