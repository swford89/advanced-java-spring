package platform.codingnomads.co.springweb.resttemplate.GET.models;

import lombok.Data;

@Data
public class BoredTemplate {
    private String activity;
    private Double accessibility;
    private String type;
    private Integer participants;
    private Double price;
    private String link;
    private String key;

    public String getActivity() {
        return activity;
    }
}
