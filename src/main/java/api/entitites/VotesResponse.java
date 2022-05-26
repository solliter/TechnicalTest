package api.entitites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class VotesResponse extends RequestEntity {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("user_id")
    @Expose
    private String user_id;

    @SerializedName("image_id")
    @Expose
    private String image_id;

    @SerializedName("sub_id")
    @Expose
    private String sub_id;

    @SerializedName("created_at")
    @Expose
    private String created_at;

    @SerializedName("value")
    @Expose
    private Integer value;

    @SerializedName("country_code")
    @Expose
    private String country_code;

    public String toJson() {
        return gson().toJson(this);
    }

}

