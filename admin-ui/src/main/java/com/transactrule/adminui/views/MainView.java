
package com.transactrule.adminui.views;

import com.transactrule.adminui.model.User;
import com.transactrule.adminui.model.UserSession;
import com.transactrule.domain.service.TenantService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.PermitAll;

/**
 * Application main class that is hidden to user before authentication.
 *
 * The class is annotated with {@code @PermitAll} to allow only authenticated
 * users to view the class.
 */
@Route("")
@PermitAll
public class MainView extends VerticalLayout {

    private final TenantService tenantService;

    public MainView(UserSession userSession, TenantService tenantService) {
        this.tenantService = tenantService;
        User user = userSession.getUser();

        add(new H1("Hello %s!".formatted(user.getFirstName())));
        add(new Paragraph("Your email is %s".formatted(user.getEmail())));

        add(new Image(user.getPicture(), "User Image"));

        var tenantUser = tenantService.findUser(user.getEmail());

        if(tenantUser.isEmpty()) {
            add(new Paragraph("You are not assigned to any tenant"));
        }
        else {
            add(new Paragraph("Your tenant is " + tenantUser.get().getTenant().getName()));
        }

        Button logoutButton = new Button("Logout", click -> {
            userSession.logout();

        });

        add(logoutButton);

        setAlignItems(Alignment.CENTER);
    }
}
