package com.github.pacificengine.template;

import io.github.pacificengine.template.api.ExampleEndpoint;
import io.github.pacificengine.template.model.ExampleRequestModel;
import io.github.pacificengine.template.model.ExampleResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExampleController implements ExampleEndpoint {
    @Override
    public ExampleResponseModel example(ExampleRequestModel request) {
        return ExampleResponseModel.builder().issuer(request.getId().toString()).build();
    }
}
