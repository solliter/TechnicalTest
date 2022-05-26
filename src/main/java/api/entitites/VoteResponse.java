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
public class VoteResponse extends RequestEntity{

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("status")
    @Expose
    private Integer status;

    @SerializedName("level")
    @Expose
    private String level;

    public String toJson() {
        return gson().toJson(this);
    }
}
