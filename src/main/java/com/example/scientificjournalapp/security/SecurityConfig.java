package com.example.scientificjournalapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = passwordEncoder();
//		System.out.println("*******************************************************");
//		System.out.println(passwordEncoder.encode("1234"));
//		System.out.println("*******************************************************");
        //super.configure(auth); ==> default username : user, and mdp : generated in the app
         auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder.
         encode("1234")).roles("USER"); // by default it doesn't work 1234 as mdp not encrypted
         auth.inMemoryAuthentication().withUser("user2").password(passwordEncoder.encode("1234")).roles("USER");
         auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.
         encode("12345")).roles("USER","ADMIN");
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select username as principal, password as credentials, active from users where username=?")
//                .authoritiesByUsernameQuery("select username as principal, role as role from users_roles where username=?")
//                .passwordEncoder(passwordEncoder)
//                .rolePrefix("ROLE_");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.formLogin();
        //http.httpBasic();
        http.formLogin().loginPage("/login"); // in controller there's /login
//        http.authorizeRequests().anyRequest().authenticated(); // anonymous : any one can access , authenticated : opposite
//        http.authorizeRequests().antMatchers("/login","/webjars/**").permitAll();
//        http.authorizeRequests().antMatchers("/css/**","/images/**","/fonts/**","/js/**", "/plugins/**", "/vendor/**").permitAll();
        /***************************SETTING SECURITY LAYER ON VIEWS***************************/
        http.authorizeRequests().antMatchers("/","/displayCategories/**",
                "/displaySubmissions/**").authenticated();

        /***************************SETTING SECURITY LAYER ON FORMS***************************/
        http.authorizeRequests().antMatchers("/","/formCautions/**",
                "/formDevises/**", "/formBanques/**", "/formMarches/**","/formAgences/**",
                "/formPaiements/**", "/formSocietes/**", "/formComptes/**", "/formTiers/**",
                "/formEncaissements/**","/formDecaissements/**", "/formLignesCredits/**",
                "/formTermes/**","/formStatuts/**","/formTypeActions/**",
                "/formDevisesTaux/**").authenticated();


        http.csrf().disable(); // .disable to make it off; it's a protection against csrf attacks (cookies & session auth)
        http.exceptionHandling().accessDeniedPage("/notAuthorized");
        /**************************MANAGE THE SESSION*****************/
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
        // isAnonymous() = !isAuthenticated()
    }
    /*
     * @Override public void configure(WebSecurity web) throws Exception { web
     * .ignoring() .antMatchers("/resources/**"); // }
     */

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
