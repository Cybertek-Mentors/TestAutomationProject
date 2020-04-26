To run tests over the jenkins, specify following top-level maven target as a build part:


clean test -Dcucumber.options="--tags @driver"


you can specify any tags that are available in your project

To run smoke test use:

clean test -P Smoke