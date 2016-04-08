cd dist
git init
git remote add https://github.com/Aidbox/site.git
git remote add origin https://github.com/Aidbox/site.git
git co -b gh-pages
git add .
git ci -m 'build'
git push origin gh-pages --force
