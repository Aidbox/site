## Simple queues & watchers API

Queues and watchers is simple, but flexible tool to
create workflows in aidbox.


## Working with queues and jobs

#### GET queues/

list queues

#### POST queues/

```
{id: 'queue name', description: 'description'}
```
 create new queue

#### POST queues/[queue-name]/jobs
```
{} // any payload
```
create new job

#### POST queues/[queue-name]/[attr]/[value]/[attr]/[value]
```
{} // any payload
```
create new job with {attr: value} merged into payload

#### GET queues/[queue-name]/job-id
get job

#### DELETE queues/[queue-name]/job-id
pick job

#### DELETE queues/[queue-name]/[attr]/[value]/[attr]/[value]
search jobs with attr=value
