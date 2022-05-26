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
public class CreateVoteRequest extends  RequestEntity{

    @SerializedName("image_id")
    @Expose
    private String image_id;

    @SerializedName("sub_id")
    @Expose
    private String sub_id;

    @SerializedName("value")
    @Expose
    private Integer value;


    public String toJson() {
        return gson().toJson(this);
    }
}
