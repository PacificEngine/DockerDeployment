package io.github.pacificengine.template.api;

import io.github.pacificengine.template.model.ExampleRequestModel;
import io.github.pacificengine.template.model.ExampleResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface ExampleEndpoint {
    @PostMapping("/template/v2/template")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    ExampleResponseModel example(@RequestBody ExampleRequestModel request);
}
