package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    @Autowired
    private Environment environment;

    public String buildTaskCountEmail(String message) {

        Context context = new Context();
        context.setVariable("is_trello_card_mail", false);
        context.setVariable("message", message);
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("is_friend", true);
        context.setVariable("company_details", prepareCompanyDetails());

        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String buildTrelloCardEmail(String message) {
        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("is_trello_card_mail", true);
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("goodbye_message", "Regards, Crud App Team");
        context.setVariable("company_details", prepareCompanyDetails());
        context.setVariable("show_button", true);
        context.setVariable("is_friend", false);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    private String prepareCompanyDetails(){
        String companyDetails = "";
        companyDetails = companyDetails.concat(environment.getProperty("info.company.name"))
                .concat(" email: " + environment.getProperty("info.company.email"))
                .concat(" phone: " + environment.getProperty("info.company.phone"));

        return companyDetails;
    }
}
