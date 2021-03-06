/*-
 * #%L
 * Eureka! Clinical User Services
 * %%
 * Copyright (C) 2016 Emory University
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.eurekaclinical.user.service.entity;

import org.eurekaclinical.user.client.comm.authentication.AuthenticationMethod;
import org.eurekaclinical.user.client.comm.authentication.LoginType;


import org.eurekaclinical.user.service.dao.AuthenticationMethodDao;
import org.eurekaclinical.user.service.dao.LoginTypeDao;
/**
 *
 * @author miaoai
 */
public final class UserEntityFactory {
	private final LoginTypeDao loginTypeDao;
	private final AuthenticationMethodDao authenticationMethodDao;
	
	public UserEntityFactory(LoginTypeDao inLoginTypeDao, AuthenticationMethodDao inAuthenticationMethodDao) {
		if (inLoginTypeDao == null) {
			throw new IllegalArgumentException("inLoginTypeDao cannot be null");
		}
		if (inAuthenticationMethodDao == null) {
			throw new IllegalArgumentException("inAuthenticationMethodDao cannot be null");
		}
		this.loginTypeDao = inLoginTypeDao;
		this.authenticationMethodDao = inAuthenticationMethodDao;
	}
	
	public LocalUserEntity getLocalUserEntityInstance() {
		LoginTypeEntity loginType = this.loginTypeDao.getByName(LoginType.INTERNAL);
		AuthenticationMethodEntity authenticationMethod = 
				this.authenticationMethodDao.getByName(AuthenticationMethod.LOCAL);
		return new LocalUserEntity(loginType, authenticationMethod);
	}
	
	public LdapUserEntity getLdapUserEntityInstance() {
		LoginTypeEntity loginType = this.loginTypeDao.getByName(LoginType.INTERNAL);
		AuthenticationMethodEntity authenticationMethod = 
				this.authenticationMethodDao.getByName(AuthenticationMethod.LDAP);
		return new LdapUserEntity(loginType, authenticationMethod);
	}
	
	public OAuthUserEntity getOAuthUserEntityInstance() {
		LoginTypeEntity loginType = this.loginTypeDao.getByName(LoginType.PROVIDER);
		AuthenticationMethodEntity authenticationMethod = 
				this.authenticationMethodDao.getByName(AuthenticationMethod.OAUTH);
		return new OAuthUserEntity(loginType, authenticationMethod);
	}
}
