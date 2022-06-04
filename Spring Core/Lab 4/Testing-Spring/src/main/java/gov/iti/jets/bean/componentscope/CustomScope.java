package gov.iti.jets.bean.componentscope;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.context.annotation.ScopeMetadataResolver;

public class CustomScope implements ScopeMetadataResolver {
    @Override
    public ScopeMetadata resolveScopeMetadata(BeanDefinition definition) {
        ScopeMetadata scopeMetadata = new ScopeMetadata();
        System.out.println(definition.getBeanClassName());
        return scopeMetadata;
    }

    public CustomScope() {
    }
}
