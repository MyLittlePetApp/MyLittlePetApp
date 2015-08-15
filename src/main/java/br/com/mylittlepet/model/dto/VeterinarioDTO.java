package br.com.mylittlepet.model.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


@SuppressWarnings("serial")
@XmlRootElement
public class VeterinarioDTO extends PessoaDTO implements GenericDTO, Serializable {

}
