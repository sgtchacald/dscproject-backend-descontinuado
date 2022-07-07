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
            <header className="">
                <div className="container text-center text-lg-left">
                    <div className="p-2 clearfix">
                        <h1 className="site-title mb-2">
                            <img className="img-fluid" src="images/logotipo.PNG" width={250} height={80} alt="logotipo" />
                        </h1>
                        <div className="site-nav">
                            <nav role="navigation">
                                <ul className="nav">
                                    <li className="nav-item"><a className="nav-link" href={urlTwitter} target="_blank" title="Twitter"><FaTwitter size={16}/> <span className="menu-title sr-only">Twitter</span></a></li>
                                    <li className="nav-item"><a className="nav-link" href={urlFacebook} target="_blank" title="Facebook"><FaFacebook size={16} /><span className="menu-title sr-only">Facebook</span></a></li>
                                    <li className="nav-item"><a className="nav-link" href={urlInstagram} target="_blank" title="Instagram"><FaInstagram size={16} /><span className="menu-title sr-only">Instagram</span></a></li>
                                    <li className="nav-item"><a className="nav-link" href={urlLinkedin} target="_blank" title="LinkedIn"><FaLinkedin size={16} /><span className="menu-title sr-only">LinkedIn</span></a></li>
                                    <li className="nav-item"><a className="nav-link" href={urlGitHub} target="_blank" title="GitHub"><FaGithub size={16}/><span className="menu-title sr-only">Github</span></a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </header>
      </div>
    )
  }
}
