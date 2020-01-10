package ink.chebotarium.api.product.service;

import ink.chebotarium.api.product.model.Product;
import ink.chebotarium.api.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImp {
    private final ProductRepository productRepository;

    Mono<Product> findById(final long id){
        return productRepository.findById(id);
    }

}
