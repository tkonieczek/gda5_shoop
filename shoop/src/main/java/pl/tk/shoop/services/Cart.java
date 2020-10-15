package pl.tk.shoop.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import pl.tk.shoop.model.CartItem;
import pl.tk.shoop.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
ScopedProxyMode - TARGET_CLASS
W przykładach przytoczonych powyżej w kilku miejscach użyliśmy dodatkowego atrybutu adnotacji
@Scope - proxyMode. Atrybut ten mówi Springowi, że w momencie tworzenia kontekstu aplikacji ma on
        stworzyć i wstrzyknąć - zamiast obiektu docelowego - obiekt proxy.
        Następnie, gdy tylko zaistnieją odpowiednie warunki (zostanie stworzona sesja, bądź serwer otrzyma request HTTP w zależności do rodzaju zakresu)
        zostanie dopiero stworzona instancja docelowa obiektu. Dlaczego tak jest?
        Wszystko przez to, że w momencie tworzenia kontekstu aplikacji
        nie istnieje jeszcze żadne aktywne żądanie lub sesja, więc nie można stworzyć w pełni reprezentatywnego obiektowego
        odpowiednika sesji czy też żądania. Co się zatem stanie jeśli nie podamy tego atrybutu? Wtedy już podczas startu aplikacji otrzymamy bardzo "sympatyczny" wyjątek: */

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {

    List<CartItem> itemsList;

    public Cart() {
        itemsList = new ArrayList<>();
    }

    public void addToCart(Product product) {
        Optional<CartItem> any = itemsList.stream().filter(it -> it.getProduct().getId() == product.getId()).findAny();
        any.ifPresentOrElse(CartItem::increase, () -> {
            itemsList.add(new CartItem(product, 1));
        });
    }

    public void addToCart(Product product, int numberOfProducts) {
        Optional<CartItem> any = itemsList.stream().filter(it -> it.getProduct().getId() == product.getId()).findAny();
        any.ifPresentOrElse(it -> it.increase(numberOfProducts), () -> {
            itemsList.add(new CartItem(product, numberOfProducts));
        });
    }

    public List<CartItem> getItemsList() {
        return itemsList;
    }

}
