# Pacote Box

<p>A classe <a href="https://github.com/arataca89/java/blob/main/Box/Box.java">Box</a> implementa uma matriz bidimensional de caracteres para ser usada em softwares CLI (com interface de linha de comando).</p>
<p>A classe BoxTitle herda de Box e é uma Box especializada para exibir títulos.</p>
<p>O arquivo <a href="https://github.com/arataca89/java/blob/main/BoxTest.java">BoxTest.java</a> demonstra o uso das classes.</p>
<p>Abaixo vemos os prints da execução deste teste.</p>
<p><img src="https://github.com/arataca89/java/blob/main/Box/box1.PNG"></p>
<p>Abaixo temos a inserção de string na Box. Observe que o programador deve cuidar com a posição inicial e com o tamanho da string
para que esta não invada a borda da Box. Se a string exceder o tamanho da Box será truncada. Para inserir string use o método <tt>insertString()</tt>.</p>
<p><img src="https://github.com/arataca89/java/blob/main/Box/box2.PNG"></p>
<p>Textos são inseridos dentro da Box preservando a borda. Observe que as palavras não são divididas. Se uma palavra exceder o limite da Box será deslocada
para a próxima linha. Se o texto exceder o limite total de caracteres da Box será trucado. Para inserir texto use o método <tt>insertText()</tt>.</p>
<p><img src="https://github.com/arataca89/java/blob/main/Box/box3.PNG"></p>
<p>Abaixo vemos como exibir um menu para uma aplicação CLI usando BoxTitle para o título e Box para exibir o menu. Para exibir o menu foi usada a 
  função <tt>insertString()</tt> para podermos colocar cada linha do menu na posição desejada da Box.</p>
<p><img src="https://github.com/arataca89/java/blob/main/Box/box4.PNG"></p>
<p>arataca89@gmail.com</p>
<p>Aulas particulares de programação</p>
<p></p>
