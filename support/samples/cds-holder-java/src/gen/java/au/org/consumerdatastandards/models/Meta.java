package au.org.consumerdatastandards.models;

import java.util.Objects;

public class Meta {

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Meta meta = (Meta) o;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Meta {\n");

        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     * 
     * ONLY inject this if objects have items
     */
    /**
     * private String toIndentedString(Object o) { if (o == null) { return "null"; }
     * return o.toString().replace("\n", "\n "); }
     */
}
