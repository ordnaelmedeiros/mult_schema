package com.medeiros.ordnael.multschema.resources.oauth;

import java.sql.Timestamp;
import java.util.Base64;
import java.util.Date;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.medeiros.ordnael.multschema.entitys.Logado;
import com.medeiros.ordnael.multschema.entitys.Operador;
import com.medeiros.ordnael.multschema.resources.operador.OperadorResources;
import com.medeiros.ordnael.multschema.utils.JPAUtils;

public class OauthResources {

	private EntityManager em;
	public EntityManager getEm() {
		if (this.em==null) {
			this.em = JPAUtils.createEntityManager();
		}
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	public Criteria createCriteria(@SuppressWarnings("rawtypes") Class classe) {
		Session session = this.getEm().unwrap(org.hibernate.Session.class);
		return session.createCriteria(classe);
	}
	
	public void close() {
		this.getEm().close();
		this.setEm(null);
	}
	
	
	public Logado login(String authorization) throws Exception {
		
		try {

			Operador ope = new OperadorResources().getOperadorByBase64(authorization);
			
			long time = new Date().getTime();
			
			String token = new String(Base64.getEncoder().encode((authorization+time).getBytes()));
			
			
			this.getEm().getTransaction().begin();
			
			Logado logado = (Logado)this.createCriteria(Logado.class)
					.add(Restrictions.eq("operador.operadorId", ope.getOperadorId()))
					.uniqueResult();
			if (logado==null) {
				logado = new Logado();
			}
			logado.setOperador(ope);
			logado.setInicioSessao(new Timestamp(time));
			logado.setAutorizacao(authorization);
			logado.setToken(token);
			
			if (logado.getLogadoId()==null) {
				this.getEm().persist(logado);
			} else {
				this.getEm().merge(logado);
			}
			
			this.getEm().getTransaction().commit();
			this.close();
			
			return logado;
			
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public static void main(String[] args) {
		//String str = "admin::admin";
		String str = "leandro::123";
		
		// encode data on your side using BASE64
		byte[] bytesEncoded = Base64.getEncoder().encode(str.getBytes());
		String strEncod = new String(bytesEncoded );
		System.out.println("ecncoded value is " + strEncod);

		// Decode data on other side, by processing encoded data
		byte[] valueDecoded= Base64.getDecoder().decode(strEncod.getBytes());
		String loginSenha = new String(valueDecoded);
		System.out.println("Decoded value is " + loginSenha);
		String[] split = loginSenha.split("::");
		System.out.println(split[0] + " - " + split[1]);
	}
	
	
}
