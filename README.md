# Mi Proyecto con GitHub Actions

Este proyecto sirve para aprender a usar GitHub Actions 🚀
## a) Identificación de herramientas de generación de documentación. ¿Qué herramienta o generador (p. ej., Sphinx, pdoc, Javadoc, JSDoc, TypeDoc) utilizaste para crear la documentación HTML?
*  Utilicé javadoc
## b) Documentación de componentes. Muestra un fragmento del código con comentarios/docstrings estructurados (p. ej., :param, :return:, @param, @return) que haya sido procesado por la herramienta. Comenta qué estilo de documentación has utilizado.
* El estilo que e utilizado es el de javadoc
/**
     * Crea un nuevo producto con los datos proporcionados.
     *
     * @param nombre nombre del producto
     * @param unidades cantidad inicial disponible
     * @param descripcion breve descripción del producto
     * @param precio precio unitario del producto
     * @throws IllegalArgumentException si nombre es vacío, unidades o precio
     * son negativos
     */
## c) Publicación en GitHub Pages. ¿Qué configuración del workflow y del repositorio utilizaste para publicar la documentación en GitHub Pages? Explica los pasos clave (acción peaceiris/actions-gh-pages, configuración de Pages en Settings).
* Configuración del Workflow (YAML):
- Utilicé la acción peaceiris/actions-gh-pages@v3 en el workflow de GitHub Actions.
- Esta acción utiliza el ${{ secrets.GITHUB_TOKEN }} (con permisos de escritura) para subir el contenido de la carpeta de salida de Javadoc (publish_dir: docs/api) a la rama especial gh-pages del repositorio.
* Configuración del Repositorio (Settings):
- Se accedió a Settings -> Pages.
- Se configuró la Source (Fuente) como Deploy from a branch.
- Se seleccionó la Branch (Rama): gh-pages.
- Se seleccionó la Folder (Carpeta): / (root).

## d) Colaboración. Explica cómo GitHub Pages facilita compartir documentación actualizada con el equipo y usuarios externos. ¿Qué ventajas tiene frente a solo tener los archivos HTML en el repositorio?
* Podemos tener una url publica que permite que cualquier persona pueda acceder a la documentacion a traves de un enlace.
* Siempre está actualizado ya que se publica automaticamente con cada cambio .
* Y es mucho mas accesible que andar descargando manuales.
## e) Control de versiones. Muestra mensajes de commit que evidencien la configuración del workflow de publicación. ¿Son claros y descriptivos? Justifícalo.
* Mensaje de Commit (Ejemplo): Moficar el ci.yaml para que genere y publique la documentacion de mi codigo java
* El mensaje es descriptivo porque indico lo que e modificado
## f) Accesibilidad y seguridad. ¿Cómo garantizas que la documentación en GitHub Pages es accesible públicamente pero el código fuente solo es accesible para personal autorizado? (repositorio privado vs. Pages público, configuración de visibilidad).
* Como el repositorio se mantiene como privado esto garantiza que los colaboradores con acceso puedan ver, clonar y modificar el codigo
* GitHub Pages configura la documentación html publicamente sirviendo archivos staticos a traves de la url
## g) Instalación/uso documentados. Indica dónde en el README.md explicas cómo acceder a la documentación publicada en GitHub Pages y dónde detallas las herramientas y comandos usados para generarla.
* A traves del enlace publico detallo la respuesta en la pregunta c
* Las herramientas y los comandos los detallo en la pregunta a 
## h) Integración continua y despliegue continuo (CI/CD). Justifica por qué el workflow utilizado implementa CI/CD. ¿Qué evento dispara automáticamente la generación y publicación de la documentación? ¿Por qué esto es despliegue continuo?
* El evento que dispara automaticamente la generacion y publicacion de la documetacion es al hacer push en la rama main
* CI (Integración Continua): El workflow se ejecuta automáticamente en cada push para integrar el código y generar la nueva documentación (build).

* CD (Despliegue Continuo): Se implementa porque inmediatamente después de la generación, la documentación HTML se publica (despliega) de forma automática en el entorno público (GitHub Pages) sin requerir ningún paso manual adicional por parte del desarrollador. El push es la única acción necesaria para actualizar el sitio web.

## i)Multiformato (opcional). ¿Qué segundo formato (además de HTML) generaste? Explica la herramienta, configuración y comandos utilizados. ¿Dónde se puede acceder a este formato?
* Un pdf 
* Utilice la herramineta Doxygen + LaTeX 
* Doxygen utiliza un proyecto LaTeX para generar pdf con make pdf
* La configuración se utiliza de un archivo llamado Doxyfile conde expecificamos que vamos a generar, el directorio dode se alojara...
* Comandos:
```
 sudo apt-get update
 sudo apt-get install -y doxygen texlive-latex-extra
 doxygen Doxyfile
 docs/doxygen_output/latex/
 make pdf
 cp refman.pdf ../../../documentacion.pdf
 mv ../../../documentacion.pdf ../../../docs/documentacion.pdf
docs/documentacion.pdf
```
* Para acceder al pdf en el propio github en Actions => última ejecución => Artifacts
* Se localiza el archivo pdf para descargar
## enlace 
* https://celia439.github.io/2526_DAW_u1_action/

## Estado de los tests
✅ Tests correctos
