import React,{ useState, useCallback, useEffect } from 'react';
import 'primeflex/primeflex.css';
import { InputText } from 'primereact/inputtext';
import { Container, Botao } from './styles';
import '../../styles.css'
import api from '../../Services/api';



const Form = () => {

    const [provedor, setProvedor] = useState([]);
    const [integracao, setIntegracao] = useState([]);


    const loadProvedores = useCallback(
        () => {
            api.get('provedor').then((response) => {
                setProvedor(response.data);
                console.log(response.data)
            }).catch((error) => {alert("Impossível carregar os provedores.");});
        }
    );


    const loadIntegracao = useCallback(
        () => {
            api.get('integracao').then((response) => {
                setIntegracao(response.data);
                console.log(response.data);
            }).catch((error) => {alert("Impossível carregar as integrações.");});
        }
    );
    
    function integracaoChangeHandler (e, index) {
       
        var integracaoAtual = integracao;
        var integracaoNova = integracaoAtual;
        integracaoAtual.find((integr) => integr.id == index).provedor.id = e.target.value;
        setIntegracao(integracaoNova);
    }

    function portaChangeHandler(e, index) {
        console.log(e.target.value)
        console.log(index)
        var integracaoAtual = integracao;
        var integracaoNova = integracaoAtual;
        integracaoAtual.find((integr) => integr.id == index).porta = e.target.value;
        setIntegracao(integracaoNova);
        console.log(integracao);
    }

    function Dropdown(props) {
        if (props.integracao.id != 3) {
            return(
                <select onChange={(e) => integracaoChangeHandler(e, props.integracao.id)}>{props.provedor.map((prov) => <option value={prov.id} selected={props.integracao.provedor.id == prov.id} key={prov.id}>{prov.nome + " (" + prov.ip + ")"}</option>)}</select>
            );
        }
        else{
            return(
                <select disabled ><option selected key={props.integracao.provedor.id}>{props.integracao.provedor.ip}</option>)</select>
            );
        }
    }

    function Formulario(){
        return (
            integracao.map(
                (integr)=>{
                    return (
                        
                    <div className="p-formgroup-inline p-justify-between">
                        <div className="p-field">
                            <label htmlFor={"conexao"+integr.nome} className="p-sr-only">Ip conexão {integr.nome}</label>
                            <Dropdown provedor={provedor} integracao={integr} />
                        </div>
                        <div className="p-field">
                            <label htmlFor={"porta"+integr.nome} className="p-sr-only">Porta</label>
                                <InputText id={"porta"+integr.nome} type="text" value={integr.porta} onChange={(e) => portaChangeHandler(e, integr.id)}/>
                        </div>
                        
                    </div>)
                }
            )


        );
    }

    function Salvar(){
        integracao.map((integr) => {
            api.put('/integracao/' + integr.id, integr)
            .then((response) => alert("Salvo com sucesso!")) 
            .catch((error) => alert("Erro ao salvar!"));      
        
        })
    }


    useEffect(
        () => {
            loadProvedores();
            loadIntegracao();
        }, []
    )

    
    return(
        <Container>
          

            < Formulario/>
           <div id="principal">
           <Botao onClick= {() => Salvar()}>Salvar</Botao>
           </div>

        </Container>
    )
}

export default Form;