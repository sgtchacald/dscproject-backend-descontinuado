import React, { Component } from 'react';
import { FaTwitter, FaFacebook, FaInstagram, FaLinkedin, FaGithub } from 'react-icons/fa';

const urlTwitter   = 'https://twitter.com/chacalsgt';
const urlFacebook  = 'https://www.facebook.com/chacalsgt/';
const urlInstagram = 'https://www.instagram.com/sgt.chacal.d/';
const urlLinkedin  = 'https://www.linkedin.com/in/diego-cordeiro-ba84a835/';
const urlGitHub    = 'https://github.com/sgtchacald';

export default class header extends Component {
  render() {
    return (
        <div>
            <footer className="pt-4 pb-3 text-center bg-light">
                <div className="container">
                    <div className="my-3">
                        <div className="h5">Diego dos Santos Cordeiro</div>
                        <p>3º Sargento EB FN de Comunicações / Desenvolvedor JAVA / Engenheiro de Testes </p>
                        <div className="footer-nav">
                            <nav role="navigation">
                                <ul className="nav justify-content-center ">
                                    <li className="nav-item"><a className="nav-link" href={urlTwitter} target="_blank" title="Twitter"><FaTwitter className="fab" size={25}/> <span className="menu-title sr-only">Twitter</span></a></li>
                                    <li className="nav-item"><a className="nav-link" href={urlFacebook} target="_blank" title="Facebook"><FaFacebook className="fab" size={25} /><span className="menu-title sr-only">Facebook</span></a></li>
                                    <li className="nav-item"><a className="nav-link" href={urlInstagram} target="_blank" title="Instagram"><FaInstagram className="fab" size={25} /><span className="menu-title sr-only">Instagram</span></a></li>
                                    <li className="nav-item"><a className="nav-link" href={urlLinkedin} target="_blank" title="LinkedIn"><FaLinkedin className="fab" size={25} /><span className="menu-title sr-only">LinkedIn</span></a></li>
                                    <li className="nav-item"><a className="nav-link" href={urlGitHub} target="_blank" title="GitHub"><FaGithub className="fab" size={25}/><span className="menu-title sr-only">Github</span></a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </footer>

      </div>
    )
  }
}
