package me.hskwon.simple_shopping_site.controllers;

import me.hskwon.simple_shopping_site.SimpleShoppingSiteApplication;
import me.hskwon.simple_shopping_site.security.WebSecurityConfig;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {
        SimpleShoppingSiteApplication.class,
        WebSecurityConfig.class,
})
public abstract class ControllerTest {
}