package com.shoppingmall.fancycart.web;

import com.shoppingmall.fancycart.utils.ExceptionUtils;
import com.shoppingmall.fancycart.service.ProductService;
import com.shoppingmall.fancycart.utils.ApiUtils;
import com.shoppingmall.fancycart.utils.RequestSuccessUtils;
import com.shoppingmall.fancycart.web.dto.ProductRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping(ApiUtils.API_VERSION)
@RestController
public class ProductApiController {

    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<?> getProductList(@Valid ProductRequestDto.Get productRequestDto, Errors errors) {
        if(errors.hasErrors()) {
            return ResponseEntity.badRequest().body(ExceptionUtils.INPUT_EXCEPTION_MESSAGE);
        }

        return ResponseEntity.ok(productService.getProductList(productRequestDto));
    }

    @PostMapping("/products")
    public ResponseEntity<String> addProduct(@Valid @RequestBody ProductRequestDto productRequestDto,
                                             Errors errors) {
        if(errors.hasErrors()) {
            return ResponseEntity.badRequest().body(ExceptionUtils.INPUT_EXCEPTION_MESSAGE);
        }

        productService.addProduct(productRequestDto);

        return ResponseEntity.ok(RequestSuccessUtils.ADD_PRODUCT_SUCCESS_MESSAGE);
    }
}
