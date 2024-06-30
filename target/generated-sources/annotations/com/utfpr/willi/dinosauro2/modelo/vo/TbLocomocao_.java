package com.utfpr.willi.dinosauro2.modelo.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TbLocomocao.class)
public abstract class TbLocomocao_ {

	public static volatile SingularAttribute<TbLocomocao, String> nome;
	public static volatile SingularAttribute<TbLocomocao, String> postura;
	public static volatile SingularAttribute<TbLocomocao, Long> id;
	public static volatile SingularAttribute<TbLocomocao, TbTaxonomia> taxonomia;

}

