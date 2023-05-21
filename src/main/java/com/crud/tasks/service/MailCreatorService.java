package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    @Autowired
    private Environment environment;

    public String buildTrelloCardEmail(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("goodbye_message", "Regards, Crud App Team");
        context.setVariable("company_details", prepareCompanyDetails());
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
