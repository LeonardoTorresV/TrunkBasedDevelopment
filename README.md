# TrunkBasedDevelopment

## Estructura de Ramas

## Rama Principal (Trunk):

main o trunk: Es la rama principal donde reside el código listo para producción. Todos los cambios importantes deben integrarse aquí, preferiblemente con versiones completamente funcionales y probadas.
Ramas de Funcionalidad (Feature Branches):

feature/<nombre-funcionalidad>: Estas ramas se crean para desarrollar nuevas funcionalidades, mejoras o cambios significativos. Deben ser de corta duración y se deben fusionar en la rama principal una vez que el trabajo esté completo y probado. Ejemplo: feature/implement-payment-service.
Ramas de Corrección de Errores (Bugfix Branches):

bugfix/<descripcion-bug>: Ramas dedicadas a corregir errores específicos. Deben ser breves y fusionarse rápidamente en la rama principal. Ejemplo: bugfix/fix-date-format.
Ramas de Soporte de Versiones (Release Branches):

release/<version>: Se usan para preparar versiones específicas para el despliegue. En estas ramas se realizan las pruebas finales y los ajustes de último momento. Ejemplo: release/1.0.0.
Ramas de Hotfix:

hotfix/<descripcion-fix>: Utilizadas para corregir errores críticos en la producción. Estas correcciones deben integrarse tanto en la rama principal como en cualquier rama de lanzamiento relevante. Ejemplo: hotfix/fix-critical-bug.

## Buenas Prácticas
Integración Continua (CI):

Configurar pipelines de CI para que se ejecuten automáticamente al hacer push a cualquier rama. Esto incluye compilación, pruebas unitarias, pruebas de integración y análisis de calidad de código.

## Commits Frecuentes y Pequeños:

Realizar commits pequeños y frecuentes para facilitar la revisión y el seguimiento de cambios. Los mensajes de commit deben ser descriptivos y claros.
Revisiones de Código (Code Reviews):

Implementar un proceso de revisión de código para cada cambio que se fusione en la rama principal. Esto ayuda a mantener la calidad del código y compartir conocimiento entre el equipo.
Pruebas Automatizadas:

Priorizar la creación de pruebas automatizadas (unitarias, de integración y de extremo a extremo) para asegurar la estabilidad y la calidad del software. Las pruebas deben ejecutarse en cada push y antes de fusionar cambios en main.
Desarrollo Basado en Características (Feature Flags):

Utilizar feature flags para desarrollar funcionalidades que no estén listas para el despliegue inmediato. Esto permite la integración temprana en main sin afectar a los usuarios finales.
Política de Fusión (Merge Policy):

Fomentar la fusión de ramas mediante pull requests (PRs) para fomentar la revisión de código y el debate técnico. Las ramas deben fusionarse en main sólo después de pasar todas las pruebas y recibir la aprobación.

## Nombre del repositorio: 
- vg-ms-academic-period.

## Rama principal: 
- main o trunk.

## Ramas de funcionalidad: 
- feature/implement-<nombre-funcionalidad>.
  
## Ramas de corrección de errores: 
- bugfix/fix-<descripcion-bug>.
  
## Ramas de lanzamiento: 
- release/<version>.
  
## Ramas de hotfix: 
- hotfix/fix-<descripcion-fix>.
