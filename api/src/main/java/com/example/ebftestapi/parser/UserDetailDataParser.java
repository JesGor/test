package com.example.ebftestapi.parser;

import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.LinkedHashMap;

/**
 * Class to parse the details of the user
 *
 * @author jesus
 */
public class UserDetailDataParser {
  /**
   * PARAMETER_PRINCIPAL
   */
  private static final String PARAMETER_PRINCIPAL = "principal";

  /**
   * PARAMETER_COMPANY_ID
   */
  private static final String PARAMETER_COMPANY_ID = "companyId";

  /**
   * Get the company id from the authentication data
   *
   * @param authentication authentication data
   * @return Long the company id
   */
  public static Long getCompanyIdFromAuthentication(OAuth2Authentication authentication) {
    LinkedHashMap<String, Object> properties = (LinkedHashMap<String, Object>) authentication.getUserAuthentication().getDetails();
    int id = (int) ((LinkedHashMap<String, Object>) properties.get(PARAMETER_PRINCIPAL)).get(PARAMETER_COMPANY_ID);
    return Long.valueOf(id);
  }
}
