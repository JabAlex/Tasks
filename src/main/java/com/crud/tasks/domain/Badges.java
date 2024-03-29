package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Badges {

    @JsonProperty("votes")
    int votes;

    @JsonProperty("attachmentsByType")
    AttachmentsByType attachments;
}
