package com.utfpr.willi.dinosauro2.modelo.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbHabitat.class)
public abstract class TbHabitat_ {

	public static volatile SingularAttribute<TbHabitat, String> geologia;
	public static volatile ListAttribute<TbHabitat, TbEspecie> especies;
	public static volatile SingularAttribute<TbHabitat, String> nome;
	public static volatile SingularAttribute<TbHabitat, Long> id;
	public static volatile SingularAttribute<TbHabitat, String> localizacao_aproximada;
	public static volatile SingularAttribute<TbHabitat, Double> temperatura_media;

}

