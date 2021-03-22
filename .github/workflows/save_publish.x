name: Release
on:
  create:  # Publish release on tag creation

jobs:
  publish:
    runs-on: ubuntu-20.04
    steps:
      - uses: actions/checkout@v2.3.4
        if: github.event.ref_type == 'tag'
        with:
          fetch-depth: 0
      - name: Reattach HEAD
        if: github.event.ref_type == 'tag'
        run: git checkout "$(echo ${{ github.ref }} | sed -E 's|refs/[a-zA-Z]+/||')"
      - uses: olafurpg/setup-scala@v10
        if: github.event.ref_type == 'tag'
      - uses: olafurpg/setup-gpg@v3
        if: github.event.ref_type == 'tag'
      - name: Show
        if: github.event.ref_type == 'tag'
        run: git rev-parse --abbrev-ref HEAD
#      - run: sbt ci-release
#        if: github.event.ref_type == 'tag'
#        env:
#          PGP_PASSPHRASE: ${{ secrets.PGP_PASSPHRASE }}
#          PGP_SECRET: ${{ secrets.PGP_SECRET }}
#          SONATYPE_PASSWORD: ${{ secrets.SONATYPE_PASSWORD }}
#          SONATYPE_USERNAME: ${{ secrets.SONATYPE_USERNAME }}