package com.example.demo.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.example.demo.dao.OpcionesDao;
import com.example.demo.dao.UsuarioDao;
@Component
public class InfoAdicionalToken implements TokenEnhancer{
	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private OpcionesDao opcionesDao;
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info1 = new HashMap<>();
		Map<String, Object> info2 = new HashMap<>();
		int idr = usuarioDao.obtenerIdRol(authentication.getName());
		System.out.println(idr);
		//info2=opcionesDao.listarOpciones(idr);
		info1 = usuarioDao.datosUsuario(authentication.getName());		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info1);
		
		return accessToken;
	}

}
