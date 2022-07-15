import React, { Component } from 'react';
import { FaDownload, FaWhatsapp } from 'react-icons/fa';

const urlCurriculo = "https://drive.google.com/file/d/1qUa_qWzZDJ6jux9AFLL1AgBa38N8xFpo/view?usp=sharing";
const urlWhatsapp = "https://api.whatsapp.com/send?phone=5521994674449&text=Ol%C3%A1,%20utilize%20o%20whatsapp%20para%20falar%20comigo,%20sempre%20respondo%20na%20hora!%20For%C3%A7a,%20f%C3%A9%20e%20uni%C3%A3o.";

export default class Content extends Component {
  render() {
    return (
      <div>
        <div className="page-content conteudo">
          <div id="content">
            <div className="cover">
              <div className="container">
                <div className="row mb-4">
                  <div className="col-lg-6"><img className="img-fluid" src="images/superfolio_hello.svg" width={532} height={442} alt="Olá Visitante" /></div>
                  <div className="col-lg-6">
                    <div className="mt-2 px-4">
                      <p className="lead text-uppercase">Olá visitante, eu sou</p>
                      <h1 className="intro-title marker">Diego Cordeiro</h1>
                      <div className="mt-3"><a className="btn btn-primary shadow-sm mt-3 text-dark" href={urlCurriculo} target="_blank">Veja meu Currículo &nbsp;&nbsp; <FaDownload/> </a></div>
                      <div className="mt-1 mb-3"><a className="btn btn-primary shadow-sm mt-3 text-dark" href={urlWhatsapp} target="_blank">Me chama no ZAP &nbsp;&nbsp;&nbsp;&nbsp;<FaWhatsapp/></a></div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    )
  }
}
